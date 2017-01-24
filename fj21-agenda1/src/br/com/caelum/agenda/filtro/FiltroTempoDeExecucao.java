package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;

@WebFilter("/*")

public class FiltroTempoDeExecucao implements Filter {
	public void dofilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, SerialException, ServletException {
		// TODO Auto-generated method stub
		long tempoInicial = System.currentTimeMillis();
		chain.doFilter(request, response);

		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest) request).getParameter("logica");

		System.out.println("Tempo da requisição de " + uri + "?logica=" + parametros + "demorou (ms):"
				+ (tempoFinal - tempoInicial));

	}

	@Override
	public boolean test(int node) {
		// TODO Auto-generated method stub
		return false;
	}

}
