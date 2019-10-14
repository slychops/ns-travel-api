node {
    stage 'Clone repository'
    checkout([
        $class: 'GitSCM',
        branches: [
            [name: '*/master']
        ],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [
            [url: 'https://github.com/nikolayantonov/ns-travel-api.git']
        ]
    ])

    stage 'Build & package'
    sh 'mvn clean package'
    //def img = docker.build('ns-travel-api-prod')
    def img = docker.build('473293451041.dkr.ecr.eu-west-2.amazonaws.com/ns-travel-api-prod')
    input'Continue to next stage?'

    stage 'Docker push'


    //sh '''
    //    eval $(aws ecr get-login --no-include-email --region eu-west-2 | sed 's|https://||')
    //    docker push 473293451041.dkr.ecr.eu-west-2.amazonaws.com/ns-travel-api-prod:latest
    //'''

    docker.withRegistry('https://473293451041.dkr.ecr.eu-west-2.amazonaws.com/ns-travel-api-prod', 'ecr:eu-west-2:ns-travel-api-prod') {
      docker.image('473293451041.dkr.ecr.eu-west-2.amazonaws.com/ns-travel-api-prod').push('latest')
    }

    //export PATH=/usr/local/bin/helm:$PATH
    ///usr/local/bin/helm init
    //usr/local/bin/helm init --service-account tiller
    //    usr/local/bin/helm init --service-account tiller
    //    /usr/local/bin/kubectl get pods --all-namespaces
    sh '''
         export KUBECONFIG=/var/lib/jenkins/.kube/config
         export PATH=/usr/local/bin/aws-iam-authenticator:$PATH
         kubectl apply -f /var/lib/jenkins/.kube/aws-auth-cm.yaml
         aws eks update-kubeconfig --region eu-west-2 --name niko-travelapp-eks-cluster
         /usr/local/bin/kubectl version
         /usr/local/bin/kubectl get nodes
         /usr/local/bin/helm upgrade --install helm-ta-prod ./helm-ta-prod
    '''
    //sh '''
    //    /usr/local/bin/helm upgrade --install helm-ta-prod --set selectApp=ns-travel-api ./helm-ta-prod
    //'''
}
