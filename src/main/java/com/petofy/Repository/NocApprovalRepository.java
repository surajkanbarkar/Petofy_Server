package com.petofy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petofy.Model.NocApproval;


@Repository
public interface NocApprovalRepository extends JpaRepository<NocApproval, Integer>{

}
