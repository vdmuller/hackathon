package hackathon.defns.serpro.pontua.servicos;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;

public class ServicoWatson {
	
	private static final String MODEL_ID = "bae850be-5ab6-4140-83bc-4e6533f968f7";
	private static final String USUARIO = "d232f093-85ce-48a8-8d16-889f5c24c8dc";
	private static final String SENHA = "3J8TCYLaIKlo";

	public void processar(String texto) {
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
				NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27, USUARIO, SENHA);

		EntitiesOptions entities = new EntitiesOptions.Builder().model(MODEL_ID).build();

		Features features = new Features.Builder().entities(entities).build();

		AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(texto).features(features).build();

		AnalysisResults response = service.analyze(parameters).execute();
		System.out.println(response);
	}
	
	public static void main(String[] args) throws IOException {
		ServicoWatson servico = new ServicoWatson();
		servico.processar("Manter perfil de usuário.");
	}

}
