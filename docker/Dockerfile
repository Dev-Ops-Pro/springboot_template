FROM fabric8/java-centos-openjdk8-jdk

EXPOSE 8080

ADD build/libs/devopsDemo.jar app.jar

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
