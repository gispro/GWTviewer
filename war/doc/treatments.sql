drop table public.treatments

--------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE public.treatments
(
  id         integer                 NOT NULL,
  lon        numeric (18, 8)         NOT NULL,
  lat        numeric (18, 8)         NOT NULL,
  category   character varying(64)   NOT NULL,
  count      integer                 NOT NULL,
  content    character varying(4092) NOT NULL,
  reported   character varying(20)   NOT NULL,
  email      character varying(64)   NOT NULL,
  CONSTRAINT treatments_id_pk PRIMARY KEY (id)
);
ALTER TABLE public.treatments OWNER TO postgres;
--------------------------------------------------------------------------------------------------------------------------------
-- delete from public.treatments
insert into treatments (id, lon, lat, category, count, reported, email, content)
    values (1, 4066120.2609918, 7595886.4741164, 'Жилишно-коммунальное хозяйство', 1, '01.06.2011 23:22:11', 'first@first.ru', '№1 Жалоба цйу йцу йцук ыва ячсмя ч муфык ыцуцыук фыв аяы Я ЫВ ячся чсфыувцыа ячсмячсячсмапр аер кервапчсмяч смч с мчсм чсмчсмчсмвкпукепукпчачс м '); 

insert into treatments (id, lon, lat, category, count, reported, email, content)
    values (2, 4012308.5930887, 7581210.5646883, 'Жилишно-коммунальное хозяйство', 2, '03.06.2011 13:31:23', 'second@second.ru', '№2 Замечание ясм ячсмыва у кпыкуеп ч сммсиьтсрьт кеарыепфывап ячаисмиьрьт вер ывепр вкп ваичсмичс итчвап ыуеп ыепр смтьопьа лшрщшщнденоыкер ыкер'); 
  
insert into treatments (id, lon, lat, category, count, reported, email, content)
    values (3, 3982956.7742324, 7482148.1760484, 'Жилишно-коммунальное хозяйство', 2, '05.06.2011 15:45:34', 'third@third.ru', '№3 Течь водопровода фуцкывап выап вапго прчспи чсмисьрлбшдюегшл енго цыен цуе йукекеркен окгл впртмиоь мрол гешлкегцкер фичсмитсрьнго укего ыккервег'); 

insert into treatments (id, lon, lat, category, count, reported, email, content)
    values (4, 3941986.5270789, 7542686.3024395, 'Жилишно-коммунальное хозяйство', 5, '15.06.2011 12:25:45', 'fourth@fourth.ru', '№4 Домофон входной двери  ФЫВ ФА ЫВФАП В ЧМыфв аывап ывап ывп вкепр еоабьтьолеврыкер ыукефвкпчсаптчапр вапр вапт ап ви ваи ыва выа выаа ыв ывр ыв ыва'); 
  
insert into treatments (id, lon, lat, category, count, reported, email, content)
    values (5, 3976230.3157445, 7611173.8797707, 'Жилишно-коммунальное хозяйство', 6, '17.06.2011 08:33:56', 'fifth@fifth.ru', '№5 Освещение лестничной площадки фыу афуа чваи чсми чспр ыукен ук ывпсями ви аено еу окерцер кер кер ук ваич см чмитчмит амппт мспит кер куер  кер кер к'); 

insert into treatments (id, lon, lat, category, count, reported, email, content)
    values (6, 4041660.4119449, 7424056.0345621, 'Жилишно-коммунальное хозяйство', 6, '18.06.2011 10:52:52', 'sixth@sixth.ru', '№6 Уборка территории фы ва фцуа фыуа фыва ыва фыва я чсмчсм ичаспи уе пукыепываи чсми чсми чспи чспи чсмип цуепнункрокуер ывер ваи ячсм чсми чси 4енкеп ывкеп'); 
    
select id, lon, lat, count from treatments    

--------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE public.treatments_cat
(
  id         integer               NOT NULL,
  pid        integer               NOT NULL,
  name       character varying(64) NOT NULL,
  CONSTRAINT treatments_cat_id_pk PRIMARY KEY (id)
);
ALTER TABLE public.treatments_cat OWNER TO postgres;
--------------------------------------------------------------------------------------------------------------------------------
-- delete from public.treatments_cat

insert into public.treatments_cat(id, pid, name) values ( 0, 0 ,'Категории');
insert into public.treatments_cat(id, pid, name) values ( 1, 0 ,'Брошенный автомобиль, мотоцикл, велосипед');
insert into public.treatments_cat(id, pid, name) values ( 2, 0 ,'Граффити, надписи на зданиях, заборах');
insert into public.treatments_cat(id, pid, name) values ( 3, 0 ,'Затопление – засор ливневой канализации');
insert into public.treatments_cat(id, pid, name) values ( 4, 0 ,'Мусор, грязь  на проезжей части');
insert into public.treatments_cat(id, pid, name) values ( 5, 0 ,'Мусор, грязь  на тротуаре');
insert into public.treatments_cat(id, pid, name) values ( 6, 0 ,'Нелегальная свалка, мусор');
insert into public.treatments_cat(id, pid, name) values ( 7, 0 ,'Неубранный снег, лед');
insert into public.treatments_cat(id, pid, name) values ( 8, 0 ,'Опасные сосульки');
insert into public.treatments_cat(id, pid, name) values (10, 0 ,'Открытые люки');
insert into public.treatments_cat(id, pid, name) values (11, 0 ,'Отсутствие номера дома, названия улицы');
insert into public.treatments_cat(id, pid, name) values (12, 0 ,'Прорыв канализации или водопровода');
insert into public.treatments_cat(id, pid, name) values (13, 0 ,'Сломанные объекты благоустройства (ограждения, скамейки и пр.)');
insert into public.treatments_cat(id, pid, name) values (14, 0 ,'Упавшее дерево,  крупные ветки');
insert into public.treatments_cat(id, pid, name) values (15, 0 ,'Ямы и трещины  на проезжей части');
insert into public.treatments_cat(id, pid, name) values (16, 0 ,'Ямы, трещины на тротуаре');
insert into public.treatments_cat(id, pid, name) values (17, 0 ,'Опасные бродячие животные (собаки, крысы и прочее)');
insert into public.treatments_cat(id, pid, name) values (18, 0 ,'Грызуны, насекомые-паразиты (большое количество)');
insert into public.treatments_cat(id, pid, name) values (19, 0 ,'Сильный шум');
insert into public.treatments_cat(id, pid, name) values (20, 0 ,'Парковка в запрещенном месте'); 
insert into public.treatments_cat(id, pid, name) values (21, 0 ,'БОМЖи');
insert into public.treatments_cat(id, pid, name) values (22, 0 ,'Не работающий светофор');
insert into public.treatments_cat(id, pid, name) values (23, 0 ,'Отсутствие уличного освещения');
insert into public.treatments_cat(id, pid, name) values (24, 0 ,'Прочее');
