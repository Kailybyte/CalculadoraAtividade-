package app.Contollertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.repositoy.CalculosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import app.controller.CalculosController;
import app.entity.Entrada;
import app.entity.Resultado;

@SpringBootTest
public class CalculosControllerTest {

    @Autowired
    CalculosController calculosController;

    @MockBean
    CalculosRepository calculosRepository;

    @BeforeEach
    void setup() {
        Resultado result = new Resultado();
        result.setSoma(15);
        result.setMedia(5.0);
        result.setMaior(6);
        result.setMenor(2);
        result.setTotalElementos(3);
        result.setMultiplicacao(24);
        result.setModa(Arrays.asList(6));
        result.setMediana(4.0);

        List<Resultado> lista = new ArrayList<>();
        lista.add(new Resultado(1, 15, 5.0, 6, 2, 3, 24, Arrays.asList(6), 4.0));
        lista.add(new Resultado(2, 20, 6.0, 7, 1, 4, 42, Arrays.asList(7), 5.5));

        Mockito.when(this.calculosRepository.save(Mockito.any())).thenReturn(result);
        Mockito.when(this.calculosRepository.findAll()).thenReturn(lista);
    }

    @Test
    @DisplayName("INTEGRAÇÃO - maior, menor, total, multiplicar, moda e mediana")
    void cenario04() {

        List<Integer> lista = Arrays.asList(2, 6, 7);
        Entrada entrada = new Entrada();
        entrada.setLista(lista);

        ResponseEntity<Resultado> retorno = this.calculosController.calcular(entrada);
        Resultado resultado = retorno.getBody();
        HttpStatusCode status = retorno.getStatusCode();

        assertEquals(15, resultado.getSoma());
        assertEquals(5.0, resultado.getMedia());
        assertEquals(6, resultado.getMaior(), "Maior número deve ser 6");
        assertEquals(2, resultado.getMenor(), "Menor número deve ser 2");
        assertEquals(3, resultado.getTotalElementos(), "Total de elementos deve ser 3");
        assertEquals(24, resultado.getMultiplicacao(), "Multiplicação deve ser 24");
        assertEquals(Arrays.asList(6), resultado.getModa(), "Moda deve ser 6");
        assertEquals(4.0, resultado.getMediana(), "Mediana deve ser 4.0");
        assertEquals(HttpStatus.OK, status);
    }

    @Test
    @DisplayName("INTEGRAÇÃO - requisição que gera moda com múltiplos valores")
    void cenario05() {

        List<Integer> lista = Arrays.asList(3, 3, 5, 5, 7);
        Entrada entrada = new Entrada();
        entrada.setLista(lista);

        Resultado result = new Resultado();
        result.setSoma(23);
        result.setMedia(4.6);
        result.setMaior(7);
        result.setMenor(3);
        result.setTotalElementos(5);
        result.setMultiplicacao(1575);
        result.setModa(Arrays.asList(3, 5));
        result.setMediana(5.0);

        Mockito.when(this.calculosRepository.save(Mockito.any())).thenReturn(result);

        ResponseEntity<Resultado> retorno = this.calculosController.calcular(entrada);
        Resultado resultado = retorno.getBody();
        HttpStatusCode status = retorno.getStatusCode();

        assertEquals(23, resultado.getSoma());
        assertEquals(4.6, resultado.getMedia(), 0.01);
        assertEquals(7, resultado.getMaior());
        assertEquals(3, resultado.getMenor());
        assertEquals(5, resultado.getTotalElementos());
        assertEquals(1575, resultado.getMultiplicacao());
        assertEquals(Arrays.asList(3, 5), resultado.getModa(), "A moda deve ser 3 e 5");
        assertEquals(5.0, resultado.getMediana(), "Mediana deve ser 5.0");
        assertEquals(HttpStatus.OK, status);
    }

    @Test
    @DisplayName("INTEGRAÇÃO - requisição com lista que tem mediana ímpar")
    void cenario06() {

        List<Integer> lista = Arrays.asList(3, 5, 7);
        Entrada entrada = new Entrada();
        entrada.setLista(lista);

        Resultado result = new Resultado();
        result.setSoma(15);
        result.setMedia(5.0);
        result.setMaior(7);
        result.setMenor(3);
        result.setTotalElementos(3);
        result.setMultiplicacao(105);
        result.setModa(Arrays.asList(3, 5, 7)); // No moda found
        result.setMediana(5.0);

        Mockito.when(this.calculosRepository.save(Mockito.any())).thenReturn(result);

        ResponseEntity<Resultado> retorno = this.calculosController.calcular(entrada);
        Resultado resultado = retorno.getBody();
        HttpStatusCode status = retorno.getStatusCode();

        assertEquals(15, resultado.getSoma());
        assertEquals(5.0, resultado.getMedia());
        assertEquals(7, resultado.getMaior());
        assertEquals(3, resultado.getMenor());
        assertEquals(3, resultado.getTotalElementos());
        assertEquals(105, resultado.getMultiplicacao());
        assertEquals(Arrays.asList(3, 5, 7), resultado.getModa(), "Sem moda específica, deve retornar todos");
        assertEquals(5.0, resultado.getMediana(), "Mediana deve ser 5.0");
        assertEquals(HttpStatus.OK, status);
    }

}
