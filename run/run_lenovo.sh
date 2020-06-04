
git pull git@bitbucket.org:autonomicbsc/cloudsim-plus.git

sh ../script/bootstrap.sh build

nohup sh ../script/bootstrap.sh org.cloudsimplus.examples.traces.PlanetLabExperiments >> 7.8fin.out 2>&1 &

