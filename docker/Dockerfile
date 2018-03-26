FROM centos:7.2.1511

ARG BUILDER_HOST
ARG DOCKER_IMAGE
ARG GIT_REPO
ARG GIT_BRANCH
ARG GIT_HASH
ARG DOCKER_TAG
ARG BUILD_DATE

ENV SERVICE_VERSION="${DOCKER_TAG:-unknown}"

RUN \
	yum clean metadata && \
	yum -y install epel-release && \
	yum clean metadata && \
	yum -y install make which tar rpm-build yum-utils python-argparse python-yaml java-1.8.0-openjdk-devel gcc gcc-c++ createrepo jq glibc-static && \
	yum clean all

ENV MAVEN_VERSION=3.5.2
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
ENV MAVEN_HOME=/opt/apache-maven-${MAVEN_VERSION}

RUN \
	mkdir -p /download && \
	curl -o /download/apache-maven-${MAVEN_VERSION}-bin.tar.gz http://apache.cs.utah.edu/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
	mkdir -p /opt && \
	cd /opt && \
	tar -zxf /download/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
	ln -sf "${MAVEN_HOME}/bin/mvn" /usr/bin/mvn

EXPOSE 3000
EXPOSE 8080

ADD build/libs/verifi.jar app.jar

COPY docker/entrypoint.sh entrypoint.sh
COPY docker/healthCheck.sh healthCheck.sh

RUN chmod +rx /*.sh \
&& chmod +rx /*.jar

ENTRYPOINT ["./entrypoint.sh"]

HEALTHCHECK CMD ./healthCheck.sh

LABEL dev_ops_pro.springboot_template.image=${DOCKER_IMAGE:-devops_pro_demo}
LABEL dev_ops_pro.springboot_template.builder="${BUILDER_HOST:-UNKNOWN}"
LABEL dev_ops_pro.springboot_template.git.repo=${GIT_REPO:-Dev-Ops-Pro/springboot_template}
LABEL dev_ops_pro.springboot_template.git.branch="${GIT_BRANCH:-UNKNOWN}"
LABEL dev_ops_pro.springboot_template.git-sha="${GIT_HASH:-UNKNOWN}"
LABEL dev_ops_pro.springboot_template.version="${DOCKER_TAG:-?.?.?}"
LABEL dev_ops_pro.springboot_template.build-date="${BUILD_DATE:-UNKNOWN}"