package com.example.solva_bank.test;
import com.example.solva_bank.Dto.BankDto;
import com.example.solva_bank.services.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BankServiceTest {

    @InjectMocks
    private BankService bankService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateLimitExceeded() throws Exception {
        Method method = BankService.class.getDeclaredMethod("calculateLimitExceeded", BankDto.class);
        method.setAccessible(true);

        BankDto bankDto = new BankDto();

        // СУММА > Limits
        bankDto.setLimitUSD(new BigDecimal("1000"));
        bankDto.setTransaction(new BigDecimal("1200"));
        Boolean result = (Boolean) method.invoke(bankService, bankDto);
        assertTrue(result, "The limit should be exceeded");

        // S < LIMITS
        bankDto.setLimitUSD(new BigDecimal("1500"));
        bankDto.setTransaction(new BigDecimal("1200"));
        result = (Boolean) method.invoke(bankService, bankDto);
        assertFalse(result, "The limit should not be exceeded");

        // =
        bankDto.setLimitUSD(new BigDecimal("1200"));
        bankDto.setTransaction(new BigDecimal("1200"));
        result = (Boolean) method.invoke(bankService, bankDto);
        assertFalse(result, "The limit should not be exceeded");
    }
}