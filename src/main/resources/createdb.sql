CREATE SEQUENCE public.player_id_seq;

CREATE TABLE public.player (
                play_id INTEGER NOT NULL DEFAULT nextval('public.player_id_seq'),
                play_pseudo VARCHAR(50) NOT NULL UNIQUE,
                play_score INTEGER NOT NULL,
                CONSTRAINT play_id PRIMARY KEY (play_id)
);


ALTER SEQUENCE public.player_id_seq OWNED BY public.player.play_id;

alter table player owner to mable;
