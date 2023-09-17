package com.example.mowitnow;

import com.example.mowitnow.services.TondeuseServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseServiceImplTest {

    @InjectMocks
    private TondeuseServiceImpl tondeuseService;

    @Test
    void executeInstructions_shouldExecuteInstructionsCorrectly() {
        MockitoAnnotations.openMocks(this);

        // modifier le test.txt pour modifier les instructions
        String input = "test.txt";

        String resultTondeuse = tondeuseService.executeInstructions(input);

        // Vérifier le résultat
        assertEquals('1', resultTondeuse.charAt(1));
        assertEquals('3', resultTondeuse.charAt(3));
        assertEquals('N', resultTondeuse.charAt(5));
    }
}
