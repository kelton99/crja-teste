select
	p.id,
	p.nome,
	d.titulo,
	sum(t.duracao) as horas_gastas
from
	pessoas p
left join tarefas t
on
	t.id_pessoa = p.id
left join departamentos d
on
	p.id_departamento = d.id
group by
	p.id,
	p.nome,
	d.titulo
order by
	sum(t.duracao) desc
limit 1