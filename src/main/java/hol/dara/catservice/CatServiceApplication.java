package hol.dara.catservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import hol.dara.catservice.dao.ProduitRepository;
import hol.dara.catservice.entities.Produit;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository prodRep;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restConfiguration.exposeIdsFor(Produit.class);
		prodRep.save(new Produit(null, "computer dell", 7500, 10));
		prodRep.save(new Produit(null, "printers hp ", 1000, 5));
		prodRep.save(new Produit(null, "smartphone samsung", 5000, 7));

		prodRep.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
	}

}
