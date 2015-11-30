package br.com.jsbse.gspm.mvc.aplicacao;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import br.com.jsbse.arquitetura.mensagem.FabricaDeMensagens;
import br.com.jsbse.arquitetura.util.FabricaArquivo;

@Component("fabricaDeMensagens")
public class FabricaDeMensagensGspm extends FabricaDeMensagens {
	private Properties propriedades;
	
	@Override
	protected Properties doGetPropriedades() {
		if (propriedades == null) {
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			try {
				Resource[] resources = resolver.getResources("classpath*:/mensagens.properties");
				propriedades = FabricaArquivo.getInstance().criaProperties(resources[0].getFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return propriedades;
	}

}
