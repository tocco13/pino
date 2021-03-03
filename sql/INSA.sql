select name as emailprovider
from insa_com
where gubun = 4;

insert into insa_com
values (
5, 101, '경영지원','직종'
);

insert into insa_com
values(5, 102, '재무회계', '직종');

insert into insa_com
values(5, 103, '인사총무', '직종');

insert into insa_com
values(5, 104, '마케팅PR','직종');
insert into insa_com
values(5, 105, '영업/관리','직종');
commit;

insert into insa_com
values(
6,101,'기획부','부서'
);
insert into insa_com
values (6, 102,'인사부','부서');
insert into insa_com
values (6, 103,'총무부','부서');
insert into insa_com
values (6, 104,'마케팅부','부서');
insert into insa_com
values (6, 105,'홍보부','부서');
insert into insa_com
values(6, 106, '영업부','부서');
insert into insa_com
values (6,107,'관리부','부서');
commit;

SELECT
			name as job_rank
		FROM 
			insa_com
		WHERE 
			gubun = 1;
            
insert into insa_com
values(7,101,'초급기능사','KOSA등급');
insert into insa_com
values(7,102,'중급기능사','KOSA등급');
insert into insa_com
values(7,103,'고급기능사','KOSA등급');
insert into insa_com
values(7,104,'초급기술자','KOSA등급');
insert into insa_com
values(7, 105,'중급기술자','KOSA등급');
insert into insa_com
values(7,106,'고급기술자','KOSA등급');
commit;

SELECT
			code, name as emailprovider
		FROM 
			insa_com
		WHERE 
			gubun = 4;
            
select *
from insa_com;

select * 
from insa
where 
    sabun = 1
    AND
    name = '';

SELECT *
		FROM 
			(SELECT rownum as rnum, q.* 
			FROM 
				(SELECT *
				FROM insa
				WHERE 
				1=1
				and sabun = 1

				and name = '홍길동'

				ORDER BY
				sabun asc
				) q
			)w	;
select count()
from(
select id
from insa
where id='test123');

select id, count() total;

CREATE TABLE files (
    seq NUMBER, 
    name varchar2(100),
    file_type varchar2(100),
    file_path varchar2(100),
    org_name varchar2(100),
    save_name varchar2(100),
    file_name varchar2(500),
    file_size NUMBER  
);

SELECT nvl(max(seq)+1,1) from FILES;
insert into files(seq)
values ((select nvl(max(seq)+1,1) from files));

SELECT file_path
		FROM files
		WHERE
			seq = 1;
            
ALTER TABLE files
modify file_path varchar2(500);

CREATE TABLE files (
    seq NUMBER, 
    id varchar2(100),
    file_type varchar2(100),
    file_path varchar2(500),
    org_name varchar2(500),
    save_name varchar2(500),
    file_name varchar2(500),
    file_size NUMBER  
);

CREATE TABLE bfiles (
    bseq NUMBER, 
    bid varchar2(100),
    bfile_type varchar2(100),
    bfile_path varchar2(500),
    borg_name varchar2(500),
    bsave_name varchar2(500),
    bfile_name varchar2(500),
    bfile_size NUMBER  
);

CREATE TABLE rfiles (
    rseq NUMBER, 
    rid varchar2(100),
    rfile_type varchar2(100),
    rfile_path varchar2(500),
    rorg_name varchar2(500),
    rsave_name varchar2(500),
    rfile_name varchar2(500),
    rfile_size NUMBER  
);

	SELECT *
    FROM insa, 
		(
			SELECT 
				f.file_path, f.save_name, b.save_name, r.save_name
			FROM 
				files f, bfiles b, rfiles r
			WHERE 
				id = 		
				(
                SELECT id
				FROM insa
				WHERE 
				name='테스트')
				);

SELECT id
    FROM insa
    WHERE 
    name='테스트';

SELECT 
    sabun, join_day, retire_day, put_yn, name, reg_no, eng_name, phone, hp, pos_gbn_code, 
    cmp_reg_no, b.save_name as cmp_reg_image, b.file_path as cmp_reg_link, sex, years, email,
    zip, addr1, addr2, dept_code, join_gbn_code, i.id, pwd, salary, kosa_reg_yn, kosa_class_code, mil_yn, mil_type,
    mil_level, mil_startdate, mil_enddate, job_type, gart_level, self_intro, crm_name,
    f.file_path as profile,  r.save_name as resume, r.file_path as resumelink
FROM 
    insa i, files f, bfiles b, rfiles r
WHERE 
    i.id = (
    SELECT id
    FROM insa
    WHERE 
    name='테스트');
    
SELECT w.*
		FROM 
			(SELECT rownum as rnum, q.* 
			FROM 
				(SELECT *
				FROM insa
				WHERE 
				1=1
	
				and pos_gbn_code = '사원'

				ORDER BY
				sabun asc
				) q
			)w	
		WHERE rnum BETWEEN 1 AND 5;	
        
delete from files
where id = 'numberone';