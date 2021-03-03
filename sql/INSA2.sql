INSERT INTO insa (cmp_reg_image, profile, resume)
SELECT b.save_name, f.file_path, r.save_name
FROM bfiles b, files f, rfiles r
WHERE id = one;

commit;

	SELECT 
		    sabun, nvl(join_day,'1900/1/1') as join_day, nvl(retire_day, '1900/1/1') as retire_day, 
            nvl(put_yn,'null') as put_yn, name, reg_no, nvl(eng_name, 'null') as eng_name, nvl(phone,'null') as phone, hp, nvl(pos_gbn_code,'null') as pos_gbn_code, 
		    nvl(cmp_reg_no,0) as cmp_reg_no, bsave_name as cmp_reg_image, bfile_path as cmp_reg_link, sex, years, email,
		    nvl(zip,0) as zip, nvl(addr1,'null') as addr1, nvl(addr2,'null') as addr2, nvl(dept_code,'null') as dept_code, nvl(join_gbn_code, 'null') as join_gbn_code,
            i.id, pwd, nvl(salary,0) as salary, nvl(kosa_reg_yn,'null') as kosa_reg_yn, nvl(kosa_class_code,'null') as kosa_class_code, nvl(mil_yn,'null') as mil_yn, nvl(mil_type,'null') as mil_type,
		    nvl(mil_level,'null') as mil_level, nvl(mil_startdate,'1900/1/1') as mil_startdate, nvl(mil_enddate,'1900/1/1') as mil_enddate, nvl(job_type,'null') as job_type, 
            nvl(gart_level,'null') as gart_level, nvl(self_intro,'hello') as self_intro, nvl(crm_name,'null') as crm_name,
		    f.save_name as profile,  rsave_name as resume, rfile_path as resumelink
		FROM 
		    insa i, files f, bfiles b, rfiles r
		WHERE 
		    i.id = (
		    SELECT id
		    FROM insa
		    WHERE 
		    sabun = '3'
		    )
            and i.id = f.id
            and i.id = bid
            and i.id = rid
            ;
select distinct f.id, file_path, rsave_name, bsave_name
from files f, bfiles b, rfiles r
where id='numbertwo'
and f.id = bid
and f.id = rid
;



SELECT * from files where id='one';
select * from rfiles where id='one';
select f.name, r.save_name from files f, rfiles r where id='one';
            
select id from insa where name='ÀÏ¹ø';

SELECT 
*
		FROM 
		    insa i
		WHERE 
		    i.id = (
		    SELECT id
		    FROM insa
		    WHERE 
		    sabun = '3'
		    )
            ;