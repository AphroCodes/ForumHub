insert into perfil (id, nome)
values(1, 'ALUNO');

insert into usuario (id, nome, email, senha, perfil_id)
values(1, 'teste', 'teste@email.com', '$2a$12$F2p08.U6lUaWDSEyNjHlauz.Q8UmS7sv76VipqzkZurVmry.qctti', 1);

insert into usuario (id, nome, email, senha, perfil_id)
values(2, 'teste2', 'teste2@email.com', '$2a$12$F2p08.U6lUaWDSEyNjHlauz.Q8UmS7sv76VipqzkZurVmry.qctti', 1);

insert curso (id, nome, categoria)
values(1, 'Java', 'Programação');