--һ���˵�
create table menu(
       mid number(2) primary key,
       mname varchar2(100)
);
create sequence seq_menu_mid;
insert into menu values(seq_menu_mid.nextval,'�˵�����');
insert into menu values(seq_menu_mid.nextval,'Ȩ�޹���');
insert into menu values(seq_menu_mid.nextval,'����Ա��Ϣ');
insert into menu values(seq_menu_mid.nextval,'��Ŀ��Ϣ');

select * from menu;
--�����˵�
create table menuItem(
       iid number(4) primary key,
       mid number(2)
           constraint FK_menuItem_mid references menu(mid),
       iname varchar2(100),
       urls varchar2(100)
);
create sequence seq_menuItem_iid;
insert into menuItem values(seq_menuItem_iid.nextval,1,'�˵�ά��','menu');
insert into menuItem values(seq_menuItem_iid.nextval,2,'Ȩ�޿���','authority');
insert into menuItem values(seq_menuItem_iid.nextval,4,'������Ŀ','manager_category');
insert into menuItem values(seq_menuItem_iid.nextval,4,'�����Ŀ','view_category');

select * from menuItem for update;
commit;

--��ɫ��Ϣ
create table roles(
       rid number(2) primary key,
       rname varchar2(100)
);
create sequence seq_roles_rid;
insert into roles values(seq_roles_rid.nextval,'��������Ա');
insert into roles values(seq_roles_rid.nextval,'�ܾ���');
insert into roles values(seq_roles_rid.nextval,'���ž���');

select * from roles

create table adminInfo(
       aid number(4) primary key,
       rid number(2)
           constraint FK_adminInfo_rid references roles(rid),
       aname varchar2(100),
       pwd varchar2(200)
);
create sequence seq_roles_rid;
insert into adminInfo values(seq_roles_rid.nextval,1,'Դ��','123');

select * from adminInfo;

create table powers(
       pid number(10) primary key,
       aid number(4)
           constraint FK_powers_aid references adminInfo(aid),
       iid number(4)
           constraint FK_powers_iid references menuItem(iid)
);
create sequence seq_powers_pid;
insert into powers values(seq_powers_pid.nextval,21,1);
insert into powers values(seq_powers_pid.nextval,21,2);
insert into powers values(seq_powers_pid.nextval,21,3);
insert into powers values(seq_powers_pid.nextval,21,4);

select * from powers


select p.iid,iname,i.mid,mname,urls from powers p,menuItem i,menu m where aid=21 and p.iid=i.iid and m.mid=i.mid
