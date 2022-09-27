docker build -t 01xz/chisel3-dev:latest --no-cache --build-arg HTTP_PROXY=192.168.81.97:20171 -f Dockerfile .
docker push 01xz/chisel3-dev:latest
