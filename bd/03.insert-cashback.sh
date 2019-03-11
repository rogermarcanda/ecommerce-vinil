#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL

\connect bd_ecommerce_vinil
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(1, 'SUNDAY', 'POP', 25);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(2, 'MONDAY', 'POP', 7);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(3, 'TUESDAY', 'POP', 6);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(4, 'WEDNESDAY', 'POP', 2);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(5, 'THURSDAY', 'POP', 10);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(6, 'FRIDAY', 'POP', 15);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(7, 'SATURDAY', 'POP', 20);

INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(8, 'SUNDAY', 'MPB', 30);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(9, 'MONDAY', 'MPB', 5);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(10, 'TUESDAY', 'MPB', 10);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(11, 'WEDNESDAY', 'MPB', 15);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(12, 'THURSDAY', 'MPB', 20);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(13, 'FRIDAY', 'MPB', 25);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(14, 'SATURDAY', 'MPB', 30);

INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(15, 'SUNDAY', 'CLASSIC', 35);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(16, 'MONDAY', 'CLASSIC', 3);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(17, 'TUESDAY', 'CLASSIC', 5);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(18, 'WEDNESDAY', 'CLASSIC', 8);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(19, 'THURSDAY', 'CLASSIC', 13);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(20, 'FRIDAY', 'CLASSIC', 18);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(21, 'SATURDAY', 'CLASSIC', 25);

INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(22, 'SUNDAY', 'ROCK', 40);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(23, 'MONDAY', 'ROCK', 10);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(24, 'TUESDAY', 'ROCK', 15);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(25, 'WEDNESDAY', 'ROCK', 15);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(26, 'THURSDAY', 'ROCK', 15);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(27, 'FRIDAY', 'ROCK', 20);
INSERT INTO public.cashback (id, dia_da_semana, genero, porcentagem) VALUES(28, 'SATURDAY', 'ROCK', 40);

EOSQL