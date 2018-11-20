package deliverit.resttest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "conta", path = "conta")
public interface ContaPagarRepository extends PagingAndSortingRepository<ContaPagar, Long> {

	List<ContaPagar> findByNome(@Param("nome") String nome);

	List<ContaPagar> findByNomeOrderByNome(@Param("nome") String nome);

}
