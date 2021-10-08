Progetto Blog (in sviluppo)

L'obiettivo principale di questo progetto è quello di sviluppare una WebApplication in cui posso incontrare il maggior numero di comportamenti e funzionalità delle WebApplication.
Ho pensato di sviluppare un blog perchè mi permette di confrontarmi con upload di dati e file, gestione di un DB, gestione di request POST/GET, criptazione di password...

I problemi più stimolanti che ho riscontrato durante lo sviluppo sono:
- La ricerca real time di un blogger/post da db e la possibilità di mettere 'Mi piace' ad un post.
- La possibilità di verificare un utente tramite invio automatico di un link via mail.
- Caricare immagini personali sul server.
- Nascondere dati sensibili nelle richieste in mancanza di https
- Gestione dei tanti comandi che può ricevere il server
- Gestione Config file
- Gestione delle classi inerenti al DB
- Gestione richieste POST ripetitive.

Per quanto riguarda la ricerca real time e la possibilità di mettere 'Mi piace' avevo bisogno di fare una richiesta al server che non fosse visibile dal cliente. Per farlo ho usato le richieste ASINCRONE con JS (AJAX).

Per quanto riguarda l'invio di mail automatiche e il caricamento di file mi è bastato usare librerie esterne ed interne a Java.

Nascondere i dati sensibili dell'utente mi è servito solamente in mancanza di una connessione sicura, per farlo ho criptato le password (in questo caso SHA256) con JS e le ho inviate al server già criptate. Il server ovviamente le salva già criptate ed il processo di confronto avviene con password già criptate.

Per la gestione di tutti i comandi ho utilizzato il COMMAND PATTERN, che ho trovato molto comodo e pulito per questa situazione, scaricando la Servlet da eventuali gestioni impossibili. Una SuperClasse astratta implementerà le proprietà più usate per tutti i comandi (User in sessione e BusinessLogic). Ogni sottoclasse avrà il compito di gestire le request/response con l'uso della business logic che si occupa di dialogare con il DB.

La classe di Configurazione è una SINGLETON, avendo necessità di avere uno e un solo collegamento al DB e una sola BL.

La gestione delle classi DAO è stata la più intricata al livello logico. Avendo molte operazioni comuni per ogni entità ho separato il problema. Ogni entità ha la sua DAO che estenderà una classe astratta che si occuperà di definire i metodi che possono essere applicati a tutte le DAO. Nel momento che incontra un problema che non sa affrontare, crea un metodo astratto che sarà definito da ogni DAO che la estende, in modo che ogni DAO lo definisca come gli serve.

Legata alla gestione delle DAO c'è la gestione della Business Logic. Per fare in modo che il cliente (nel mio caso la classe astratta Command e tutte le sottoclassi) potesse lavore con l'interfaccia della business logic (tipo formale) e non la BL stessa (tipo concreto), ho avuto bisogno di utilizzare un altro pattern: FACADE. In sostanza la mia interfaccia BL avrà i metodi più complessi della WebApplication (come ad esempio il login) ma avrà anche metodi che 'ricoprono' e arricchiscono i metodi delle DAO. Concretamente questi metodi richiameranno i metodi base delle DAO relative, aggiungendo magari la possibilità di alcune condizioni o di una somma di funzionalità.

Per quanto riguarda invece le richieste POST ripetute, ho notate che inviando dei dati tramite richiesta POST di una form e volendo ritornare alla stessa pagina, se l'utente avesse ricaricato la pagina, la mia servlet avrebbe ricevuto un duplicato della richiesta precedente. Per evitarlo ho utilizzato il Pattern Post/Redirect/Get (PRG). Prima di inviare la risposta all'utente la mia servlet invierà una richiesta ad una pagina che si occupa solamente di fare un redirect alla pagina voluta, senza che l'utente se ne accorga.
