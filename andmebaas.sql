create table lauad(
ID serial primary key,
LAUA_NR integer NOT NULL,
BRONEERITUD boolean default FALSE,
KASUTAJA integer,
KOHTI integer NOT NULL,
PUBI integer NOT NULL);

create table pub(
id serial primary key,
nimi varchar(40),
asukoht varchar(40),
laudade_arv integer
);

insert into pub values(1,'Pahad Poisid','Tartu',20);
insert into pub values(2,'Virma pubi','Rakvere',40);

select LAUAD.ID, LAUAD.BRONEERITUD, LAUAD.LAUA_NR, PUB.NIMI
from LAUAD
inner join PUB
on LAUAD.PUBI=PUB.ID

create table kasutajad(
ID serial primary key,
EESNIMI varchar(40) not null,
PERENIMI varchar(40) not null,
KASUTAJANIMI varchar(40) not null,
PAROOL varchar(8000) not null,
ELUKOHT varchar(40),
EMAIL varchar(40) not null,
TELEFON varchar(40),
ADMINISTRAATOR boolean default false
);

insert into kasutajad values(1,'Indrek','Tallinn','Mikropluosto','97ffbabeeb26add60cb37ea5f43ed9c20f8f63dbb3cb131cc1a19981dbca93af','Tallinn','mikroplu@ut.ee','5345343', true);
insert into kasutajad values(2,'Mihkel','Tartu','mihu','76b0efe1ad062e56a39e71f2a7e763ff1db949cd0bfb2cb791c0cb5d5166f9cd','Tartu','mihkelk@ut.ee','58371331',false);

select * from lauad where pubi=(select ID from pub where nimi='Pahad Poisid')

SELECT lauad.laua_nr, lauad.broneeritud, lauad.kohti as Broneeritud_kohti, kasutajad.kasutajanimi as Broneerija_nimi, pub.nimi as Pubi_nimi from lauad
inner join pub
on lauad.pubi=pub.id
left join kasutajad
on lauad.kasutaja=kasutajad.id
where pub.nimi='Virma pubi'


select count(*) as laudade_arv  from (SELECT lauad.laua_nr, lauad.broneeritud, lauad.kohti as Broneeritud_kohti, kasutajad.kasutajanimi as Broneerija_nimi, pub.nimi as Pubi_nimi from lauad inner join pub	on lauad.pubi=pub.id left join kasutajad on lauad.kasutaja=kasutajad.id) as foo	where pubi_nimi='Virma pubi'	group by pubi_nimi;
	    
