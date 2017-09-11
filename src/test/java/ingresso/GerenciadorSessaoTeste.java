package ingresso;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.GerenciadorSessao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorSessaoTeste {

	@Test
	public void deveRetornarFalseQuandoNaoCabe () {
		LocalTime duasEMeia = LocalTime.of(14, 30);
		Filme f1 = new Filme ("Harry Potter", Duration.ofMinutes(120), "Aventura", BigDecimal.TEN);
		Sala sala = new Sala ("3D");
		
		Sessao s1 = new Sessao (duasEMeia, f1, sala);
		
		List<Sessao> sessoesExistentes = Arrays.asList (new Sessao (LocalTime.of(13, 00), new Filme ("Velozes e Furiosos", Duration.ofMinutes(120), "Ação", BigDecimal.TEN), sala), new Sessao (LocalTime.of(13, 00), new Filme ("A Origem", Duration.ofMinutes(90), "Ação", BigDecimal.TEN), sala), new Sessao (LocalTime.of(13, 00), new Filme ("Velozes e Furiosos", Duration.ofMinutes(120), "Ação", BigDecimal.TEN), sala));
		
		GerenciadorSessao g = new GerenciadorSessao (sessoesExistentes);
		
		Assert.assertFalse(g.cabe(s1));
	}
	
	public void deveRetornarTrueQuandoCabe () {
		LocalTime duasEMeia = LocalTime.of(14, 30);
		Filme f1 = new Filme ("Harry Potter", Duration.ofMinutes(120), "Aventura", BigDecimal.TEN);
		Sala sala = new Sala ("3D");
		
		Sessao s1 = new Sessao (duasEMeia, f1, sala);
		
		List<Sessao> sessoesExistentes = Arrays.asList ();
		
		GerenciadorSessao g = new GerenciadorSessao (sessoesExistentes);
		
		Assert.assertTrue(g.cabe(s1));
	}
}
