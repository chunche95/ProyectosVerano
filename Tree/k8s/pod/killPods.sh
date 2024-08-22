for i in $(seq 1 1000); do
  kubectl run crashloopbackoff-pod-$i --image=busybox -- /bin/false
done
