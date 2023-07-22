INSERT INTO departamentos values (1, 'Financeiro'), (2, 'Comercial'), (3, 'Desenvolvimento');

INSERT INTO pessoas values
(1, 'Camila', 1),
(2, 'Pedro', 2),
(3, 'Fabiano', 3),
(4, 'Raquel', 3),
(5, 'Patricia', 3),
(6, 'Joaquim', 1);

INSERT INTO tarefas (id, titulo, descricao, prazo, id_departamento, duracao, id_pessoa, finalizado) values
(1001, 'Validar NF Janeiro', 'Validar notas recebidas no mês de Janeiro', '2023-02-15', 1, 14, 1, true),
(1002, 'Bug 352', 'Corrigir bug 352 na versão 1.25', '2023-05-10', 3, 25, null, false),
(1003, 'Liberação da versão 1.24', 'Disponibilizar pacote para testes', '2023-02-02', 3, 2, 3, false),
(1004, 'Reunião A', 'Reunião com cliente A para apresentação do produto', '2023-02-05', 2, 5, null, false),
(1005, 'Reunião final', 'Fechamento contrato', '2023-03-28', 2, 14, null, false),
(1006, 'Pagamento 01/2022', 'Realizar pagamento dos fornecedores',  '2023-01-31', 1, 6, 1, true),
(1007, 'Bug 401', 'Corrigir bug 401 na versão 1.20',  '2023-02-01', 3, 2, 4, true),
(1008, 'Bug 399', 'Corrigir bug 399 na versão 1.20',  '2023-01-28', 3, 6, 5, true),
(1009, 'Reunião B', 'Reunião com cliente B para apresentação do produto',  '2023-01-31', 2, 5, 2, true),
(1010, 'Validar NF Fevereiro', 'Validar notas recebidas no mês de Fevereiro',  '2023-03-15', 1, 14, 6, false);