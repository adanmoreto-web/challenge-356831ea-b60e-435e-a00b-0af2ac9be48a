package com.pragma.accountmanagement.domain.usecase;



import com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException;
import com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException;
import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AccountService - Pruebas Unitarias")
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account cuentaDePrueba;
    private UUID idDePrueba;
    private static final String NUMERO_CUENTA = "1234567890";
    private static final String ID_CLIENTE = "CLIENTE-001";
    private static final String TIPO_CUENTA = "AHORROS";
    private static final BigDecimal SALDO_INICIAL = new BigDecimal("1000.00");

    @BeforeEach
    void setUp() {
        idDePrueba = UUID.randomUUID();
        cuentaDePrueba = new Account(NUMERO_CUENTA, ID_CLIENTE, SALDO_INICIAL, TIPO_CUENTA);
    }

    @Nested
    @DisplayName("Creación de Cuentas")
    class CreacionCuentas {

        @Test
        @DisplayName("Crear cuenta exitosamente cuando el número de cuenta no existe")
        void crearCuenta_Exitoso_CuandoNumeroNoExiste() {
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);
            when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> {
                Account cuenta = invocation.getArgument(0);
                return cuenta;
            });

            Account resultado = accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, SALDO_INICIAL, TIPO_CUENTA);

            assertNotNull(resultado);
            assertEquals(NUMERO_CUENTA, resultado.getAccountNumber());
            assertEquals(ID_CLIENTE, resultado.getCustomerId());
            assertEquals(SALDO_INICIAL, resultado.getBalance());
            assertEquals(TIPO_CUENTA, resultado.getAccountType());
            verify(accountRepository).existsByAccountNumber(NUMERO_CUENTA);
            verify(accountRepository).save(any(Account.class));
        }

        @Test
        @DisplayName("Crear cuenta con balance inicial cero")
        void crearCuenta_ConBalanceInicialCero() {
            BigDecimal balanceCero = BigDecimal.ZERO;
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, balanceCero, TIPO_CUENTA);

            assertNotNull(resultado);
            assertEquals(BigDecimal.ZERO, resultado.getBalance());
        }

        @Test
        @DisplayName("Crear cuenta con balance negativo lanza excepción")
        void crearCuenta_ConBalanceNegativo_LanzaExcepcion() {
            BigDecimal balanceNegativo = new BigDecimal("-100.00");
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);

            assertThrows(IllegalArgumentException.class, () ->
                accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, balanceNegativo, TIPO_CUENTA)
            );
            verify(accountRepository, never()).save(any(Account.class));
        }
    }

    @Nested
    @DisplayName("Consulta de Cuentas")
    class ConsultaCuentas {

        @Test
        @DisplayName("Obtener cuenta por ID exitosamente")
        void obtenerPorId_Exitoso() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            Account resultado = accountService.getAccountById(idDePrueba);

            assertNotNull(resultado);
            assertEquals(NUMERO_CUENTA, resultado.getAccountNumber());
            verify(accountRepository).findById(idDePrueba);
        }

        @Test
        @DisplayName("Obtener cuenta por ID cuando no existe lanza excepción")
        void obtenerPorId_CuandoNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.getAccountById(idDePrueba)
            );
        }

        @Test
        @DisplayName("Obtener cuenta por número de cuenta exitosamente")
        void obtenerPorNumeroCuenta_Exitoso() {
            when(accountRepository.findByAccountNumber(NUMERO_CUENTA)).thenReturn(Optional.of(cuentaDePrueba));

            Account resultado = accountService.getAccountByAccountNumber(NUMERO_CUENTA);

            assertNotNull(resultado);
            assertEquals(NUMERO_CUENTA, resultado.getAccountNumber());
            verify(accountRepository).findByAccountNumber(NUMERO_CUENTA);
        }

        @Test
        @DisplayName("Obtener cuenta por número de cuenta cuando no existe lanza excepción")
        void obtenerPorNumeroCuenta_CuandoNoExiste_LanzaExcepcion() {
            when(accountRepository.findByAccountNumber(NUMERO_CUENTA)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.getAccountByAccountNumber(NUMERO_CUENTA)
            );
        }

        @Test
        @DisplayName("Obtener todas las cuentas de un cliente")
        void obtenerPorCliente_Exitoso() {
            List<Account> cuentas = List.of(cuentaDePrueba);
            when(accountRepository.findByCustomerId(ID_CLIENTE)).thenReturn(cuentas);

            List<Account> resultado = accountService.getAccountsByCustomerId(ID_CLIENTE);

            assertNotNull(resultado);
            assertEquals(1, resultado.size());
            assertEquals(ID_CLIENTE, resultado.get(0).getCustomerId());
            verify(accountRepository).findByCustomerId(ID_CLIENTE);
        }

        @Test
        @DisplayName("Obtener cuentas de cliente sin cuentas retorna lista vacía")
        void obtenerPorCliente_SinCuentas_RetornaListaVacia() {
            when(accountRepository.findByCustomerId(ID_CLIENTE)).thenReturn(new ArrayList<>());

            List<Account> resultado = accountService.getAccountsByCustomerId(ID_CLIENTE);

            assertNotNull(resultado);
            assertTrue(resultado.isEmpty());
        }
    }

    @Nested
    @DisplayName("Operaciones de Depósito")
    class Depositos {

        @Test
        @DisplayName("Depósito exitoso aumenta el balance")
        void deposito_Exitoso_AumentaBalance() {
            BigDecimal montoDeposito = new BigDecimal("500.00");
            BigDecimal balanceEsperado = SALDO_INICIAL.add(montoDeposito);

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.deposit(idDePrueba, montoDeposito);

            assertNotNull(resultado);
            assertEquals(balanceEsperado, resultado.getBalance());
            verify(accountRepository).findById(idDePrueba);
            verify(accountRepository).save(any(Account.class));
        }

        @Test
        @DisplayName("Depósito en cuenta inexistente lanza excepción")
        void deposito_CuentaNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.deposit(idDePrueba, new BigDecimal("100.00"))
            );
        }

        @Test
        @DisplayName("Depósito con monto cero no modifica balance")
        void deposito_MontoCero_NoModificaBalance() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.deposit(idDePrueba, BigDecimal.ZERO);

            assertEquals(SALDO_INICIAL, resultado.getBalance());
        }

        @Test
        @DisplayName("Depósito con monto negativo lanza excepción")
        void deposito_MontoNegativo_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(IllegalArgumentException.class, () ->
                accountService.deposit(idDePrueba, new BigDecimal("-50.00"))
            );
        }
    }

    @Nested
    @DisplayName("Operaciones de Retiro")
    class Retiros {

        @Test
        @DisplayName("Retiro exitoso disminuye el balance")
        void retiro_Exitoso_DisminuyeBalance() {
            BigDecimal montoRetiro = new BigDecimal("300.00");
            BigDecimal balanceEsperado = SALDO_INICIAL.subtract(montoRetiro);

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.withdraw(idDePrueba, montoRetiro);

            assertNotNull(resultado);
            assertEquals(balanceEsperado, resultado.getBalance());
            verify(accountRepository).findById(idDePrueba);
            verify(accountRepository).save(any(Account.class));
        }

        @Test
        @DisplayName("Retiro mayor al balance lanza excepción de fondos insuficientes")
        void retiro_MayorAlBalance_LanzaExcepcion() {
            BigDecimal montoRetiro = new BigDecimal("2000.00");

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException.class, () ->
                accountService.withdraw(idDePrueba, montoRetiro)
            );
            verify(accountRepository, never()).save(any(Account.class));
        }

        @Test
        @DisplayName("Retiro igual al balance deja cuenta en cero")
        void retiro_IgualAlBalance_DejaEnCero() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.withdraw(idDePrueba, SALDO_INICIAL);

            assertEquals(BigDecimal.ZERO, resultado.getBalance());
        }

        @Test
        @DisplayName("Retiro en cuenta inexistente lanza excepción")
        void retiro_CuentaNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.withdraw(idDePrueba, new BigDecimal("100.00"))
            );
        }

        @Test
        @DisplayName("Retiro con monto negativo lanza excepción")
        void retiro_MontoNegativo_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(IllegalArgumentException.class, () ->
                accountService.withdraw(idDePrueba, new BigDecimal("-50.00"))
            );
        }
    }

    @Nested
    @DisplayName("Cierre de Cuenta")
    class CierreCuenta {

        @Test
        @DisplayName("Cerrar cuenta exitosamente")
        void cerrarCuenta_Exitoso() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            doNothing().when(accountRepository).deleteById(idDePrueba);

            accountService.closeAccount(idDePrueba);

            verify(accountRepository).findById(idDePrueba);
            verify(accountRepository).deleteById(idDePrueba);
        }

        @Test
        @DisplayName("Cerrar cuenta inexistente lanza excepción")
        void cerrarCuenta_CuentaNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.closeAccount(idDePrueba)
            );
            verify(accountRepository, never()).deleteById(any());
        }

        @Test
        @DisplayName("Cerrar cuenta con balance positivo lanza excepción")
        void cerrarCuenta_ConBalancePositivo_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(IllegalStateException.class, () ->
                accountService.closeAccount(idDePrueba)
            );
            verify(accountRepository, never()).deleteById(any());
        }
    }

    @Nested
    @DisplayName("Validaciones de Integridad")
    class ValidacionesIntegridad {

        @Test
        @DisplayName("El repository se llama correctamente en cada operación")
        void verificarLlamadasRepository() {
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, SALDO_INICIAL, TIPO_CUENTA);
            verify(accountRepository, times(1)).existsByAccountNumber(NUMERO_CUENTA);
            verify(accountRepository, times(1)).save(any(Account.class));

            reset(accountRepository);

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            accountService.getAccountById(idDePrueba);
            verify(accountRepository, times(1)).findById(idDePrueba);

            reset(accountRepository);

            when(accountRepository.findByAccountNumber(NUMERO_CUENTA)).thenReturn(Optional.of(cuentaDePrueba));
            accountService.getAccountByAccountNumber(NUMERO_CUENTA);
            verify(accountRepository, times(1)).findByAccountNumber(NUMERO_CUENTA);
        }
    }
}