PGDMP      0                |            java_learning_resources    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16432    java_learning_resources    DATABASE     �   CREATE DATABASE java_learning_resources WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
 '   DROP DATABASE java_learning_resources;
                postgres    false            �          0    16489 
   categories 
   TABLE DATA           ;   COPY public.categories (id, name, description) FROM stdin;
    public          postgres    false    216   '       �          0    16543    databasechangelog 
   TABLE DATA           �   COPY public.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) FROM stdin;
    public          postgres    false    223   D       �          0    16548    databasechangeloglock 
   TABLE DATA           R   COPY public.databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
    public          postgres    false    224   a       �          0    16525 	   favorites 
   TABLE DATA           =   COPY public.favorites (id, user_id, resource_id) FROM stdin;
    public          postgres    false    222   �       �          0    16498 	   resources 
   TABLE DATA           S   COPY public.resources (id, title, description, type, url, category_id) FROM stdin;
    public          postgres    false    218   �       �          0    16512    users 
   TABLE DATA           >   COPY public.users (id, username, email, password) FROM stdin;
    public          postgres    false    220   �       �           0    0    categories_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.categories_id_seq', 1, false);
          public          postgres    false    215            �           0    0    favorites_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.favorites_id_seq', 1, false);
          public          postgres    false    221            �           0    0    resources_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.resources_id_seq', 1, false);
          public          postgres    false    217            �           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 1, true);
          public          postgres    false    219            �      x������ � �      �      x������ � �      �      x�3�L��"�=... U�      �      x������ � �      �      x������ � �      �   '   x�3�LL��̃����9�z���C#c�=... �I     