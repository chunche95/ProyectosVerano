# Docker Swarm init
`docker swarm init --advertise-addr eth0:2377 --listen-addr eth0:2377`

# Initial default config
┌─(~)────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:27:25)──> docker swarm leave                              ──(sáb,ago24)─┘
Error response from daemon: You are attempting to leave the swarm on a node that is participating as a manager. Removing the last manager erases all current state of the swarm. Use `--force` to ignore this message.
┌─(~)────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:27:52)──> docker swarm leave --force                  1 ↵ ──(sáb,ago24)─┘
Node left the swarm.
┌─(~)────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:27:55)──> docker swarm init                               ──(sáb,ago24)─┘
Swarm initialized: current node (2vcdi27r91f57x6xao5bagtsw) is now a manager.

To add a worker to this swarm, run the following command:

    docker swarm join --token SWMTKN-1-1q4cpt74hp1wi2huedbeyfawxeano0j0w01hhm2m2n5apgrla5-29f7iqdj69hq7v2uw748q9lc8 192.168.1.144:2377

To add a manager to this swarm, run 'docker swarm join-token manager' and follow the instructions.

┌─(~)────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:28:07)──> docker node ls                            130 ↵ ──(sáb,ago24)─┘
ID                            HOSTNAME         STATUS    AVAILABILITY   MANAGER STATUS   ENGINE VERSION
2vcdi27r91f57x6xao5bagtsw *   pau              Ready     Active         Leader           27.1.2
ljmaovd3cyybm1ovr0ijrjyzf     pesteban-pauK    Ready     Active                          20.10.21
ac3uwttkao5lky4orula5fxqt     pesteban-pauK2   Ready     Active                          20.10.21
┌─(~)────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:28:55)──>

┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)──────────────────────(pesteban@pau:pts/2)─┐
└─(19:37:06 on main ✖ ✹ ✭)──> docker service create --name swarm-nginx --replicas 3 -p 8080:80 httpd:alpine
zaj3khkpzz9xqddkvy1f2klhe
overall progress: 3 out of 3 tasks 
1/3: running 
2/3: running 
3/3: running 
verify: Service zaj3khkpzz9xqddkvy1f2klhe converged 

─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)────────────────────────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:45:53 on main ✖ ✹ ✭)──> docker service ls                                                                                        ──(sáb,ago24)─┘
ID             NAME          MODE         REPLICAS   IMAGE          PORTS
zaj3khkpzz9x   swarm-nginx   replicated   3/3        httpd:alpine   *:8080->80/tcp

┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)────────────────────────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:47:19 on main ✖ ✹ ✭)──> docker service scale swarm-nginx=6                                                                   1 ↵ ──(sáb,ago24)─┘
swarm-nginx scaled to 6
overall progress: 6 out of 6 tasks 
1/6: running   [==================================================>] 
2/6: running   [==================================================>] 
3/6: running   [==================================================>] 
4/6: running   [==================================================>] 
5/6: running   [==================================================>] 
6/6: running   [==================================================>] 
verify: Service swarm-nginx converged 

─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)────────────────────────────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:48:20 on main ✖ ✹ ✭)──> docker service ps swarm-nginx                                                                      130 ↵ ──(sáb,ago24)─┘
ID             NAME            IMAGE          NODE             DESIRED STATE   CURRENT STATE            ERROR     PORTS
fcdb2fe30c2q   swarm-nginx.1   httpd:alpine   pau              Running         Running 10 minutes ago             
psijd2wf4eoi   swarm-nginx.2   httpd:alpine   pesteban-pauK    Running         Running 10 minutes ago             
e7in4sma6elz   swarm-nginx.3   httpd:alpine   pesteban-pauK2   Running         Running 10 minutes ago             
0ck2tn4parz0   swarm-nginx.4   httpd:alpine   pesteban-pauK    Running         Running 51 seconds ago             
ygdmzqa0cuwi   swarm-nginx.5   httpd:alpine   pesteban-pauK2   Running         Running 51 seconds ago             
mobjrc8j2q53   swarm-nginx.6   httpd:alpine   pau              Running         Running 51 seconds ago

---
## manager
┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)──────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:50:24 on main ✖ ✹ ✭)──> docker ps -a                                                                 130 ↵ ──(sáb,ago24)─┘
CONTAINER ID   IMAGE                                 COMMAND                  CREATED          STATUS                    PORTS     NAMES
9d63625b83d8   httpd:alpine                          "httpd-foreground"       3 minutes ago    Up 3 minutes              80/tcp    swarm-nginx.6.mobjrc8j2q53vlqt3yh4nlpb5
abc012918733   httpd:alpine                          "httpd-foreground"       12 minutes ago   Up 12 minutes             80/tcp    swarm-nginx.1.fcdb2fe30c2qnrrvh8bfyafyj

---
## Node 1
Cada 2,0s: docker ps -a                                     pesteban-pauK: Sat Aug 24 19:50:56 2024

CONTAINER ID   IMAGE          COMMAND              CREATED          STATUS          PORTS     NAMES
3f4494758f71   httpd:alpine   "httpd-foreground"   3 minutes ago    Up 3 minutes    80/tcp    swarm
-nginx.4.0ck2tn4parz0p80fu48cq8dll
ea75028de53f   httpd:alpine   "httpd-foreground"   12 minutes ago   Up 12 minutes   80/tcp    swarm
-nginx.2.psijd2wf4eoiw5kdz06gin1nv

---
## Node 2
Cada 2,0s: docker ps -a                                     pesteban-pauK2: Sat Aug 24 19:51:38 2024

CONTAINER ID   IMAGE          COMMAND              CREATED          STATUS          PORTS     NAMES
0b985eeb1370   httpd:alpine   "httpd-foreground"   4 minutes ago    Up 4 minutes    80/tcp    swarm-
nginx.5.ygdmzqa0cuwil8pihb2xa002m
852a2543c0d0   httpd:alpine   "httpd-foreground"   13 minutes ago   Up 13 minutes   80/tcp    swarm-
nginx.3.e7in4sma6elzggj4bzpirpzy9

## Update/change image
See img/updateimg.png

┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)──────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:52:26 on main ✖ ✹ ✭)──> docker service update --image nginx:alpine swarm-nginx                       130 ↵ ──(sáb,ago24)─┘
swarm-nginx
overall progress: 6 out of 6 tasks 
1/6: running   [==================================================>] 
2/6: running   [==================================================>] 
3/6: running   [==================================================>] 
4/6: running   [==================================================>] 
5/6: running   [==================================================>] 
6/6: running   [==================================================>] 
verify: Service swarm-nginx converged


┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)──────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:53:25 on main ✖ ✹ ✭)──> docker service inspect --pretty swarm-nginx                                        ──(sáb,ago24)─┘

ID:		zaj3khkpzz9xqddkvy1f2klhe
Name:		swarm-nginx
Service Mode:	Replicated
 Replicas:	6
UpdateStatus:
 State:		completed
 Started:	3 minutes ago
 Completed:	2 minutes ago
 Message:	update completed
Placement:
UpdateConfig:
 Parallelism:	1
 On failure:	pause
 Monitoring Period: 5s
 Max failure ratio: 0
 Update order:      stop-first
RollbackConfig:
 Parallelism:	1
 On failure:	pause
 Monitoring Period: 5s
 Max failure ratio: 0
 Rollback order:    stop-first
ContainerSpec:
 Image:		nginx:alpine@sha256:c04c18adc2a407740a397c8407c011fc6c90026a9b65cceddef7ae5484360158
 Init:		false
Resources:
Endpoint Mode:	vip
Ports:
 PublishedPort = 8080
  Protocol = tcp
  TargetPort = 80
  PublishMode = ingress 


## Remove service
Image /img/rmservice.png

┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)──────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(19:57:11 on main ✖ ✹ ✭)──> docker service rm swarm-nginx                                                      ──(sáb,ago24)─┘
swarm-nginx


# Abandonar el docker swarm

## Nodo manager
┌─(~/Documentos/ProyectosVerano/Tree/docker/dockerswarm)──────────────────────────────────────────────────(pesteban@pau:pts/2)─┐
└─(20:03:39 on main ✖ ✹ ✭)──> docker swarm leave --force                                                     1 ↵ ──(sáb,ago24)─┘
Node left the swarm.


## Nodos esclavos
pesteban@pesteban-pauK:~$ docker swarm leave
Node left the swarm.
pesteban@pesteban-pauK:~$ 

pesteban@pesteban-pauK2:~$ docker swarm leave
Node left the swarm.
pesteban@pesteban-pauK2:~$ 

