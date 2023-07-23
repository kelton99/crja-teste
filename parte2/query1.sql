select
	d.titulo ,
	COUNT(t.id) filter (
	where t.finalizado is true) as tarefas_finalizadas,
	COUNT(t.id) filter (
	where t.finalizado is false) as tarefas_nao_finalizadas
from
	departamentos d
left join tarefas t
on
	t.id_departamento = d.id
group by
	d.titulo