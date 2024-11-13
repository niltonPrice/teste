package agiot.voll.api.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgiotaRepository extends JpaRepository<Agiota,Long> {

    Page<Agiota> findAllByAtivoTrue(Pageable paginacao);
}
