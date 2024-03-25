CREATE TABLE tb_user(
    user_id VARCHAR2(20) PRIMARY KEY
    ,user_pw VARCHAR2(100)
    ,user_nm VARCHAR2(100)
    ,create_dt DATE
    ,update_dt DATE DEFAULT SYSDATE
    ,use_yn VARCHAR2(1) DEFAULT 'Y'
    
);
select * from tb_user;

-- ȸ�� ���� ����
INSERT INTO tb_user (user_id, user_pw, create_dt)
VALUES(:1,:2, sysdate);

INSERT INTO tb_user (user_id, user_nm, user_pw)
SELECT mem_id
     , mem_name
     , mem_pass
FROM member;

-- �α��� ����
SELECT user_id
     , user_pw
     , user_nm
FROM tb_user
WHERE user_id='a001'
AND use_yn = 'Y';

COMMIT;

UPDATE tb_user SET user_nm = ?
WHERE user_id = ?;
-- DBA������ �ִ� �ʿ����� public synonym ����
CREATE PUBLIC SYNONYM bbs FOR study.stock_bbs;  -- bbs��� ���Ǿ ����
CREATE PUBLIC SYNONYM stock FOR study.stock;    -- stock ���Ǿ� ����

GRANT SELECT ON bbs TO public;  -- �ó���� ���������� ��ȸ�ϵ���
GRANT SELECT ON stock TO public;
SELECT * FROM stock_bbs;

SELECT (SELECT name
        FROM stock
        WHERE code = a.code) as nm
        ,a.title
        ,a.read_count
        ,TO_CHAR(a.update_dt, 'YYYYMMDD HH24:MI:SS') as update_dt
FROM bbs a;

commit;