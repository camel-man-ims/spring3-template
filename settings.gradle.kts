rootProject.name = "camelman"

include("api")
include("domain")
include("application")

include("infra:infra-opensearch")
findProject(":infra:opensearch")?.name = "infra-opensearch"

include("infra:infra-mongo")
findProject(":infra:infra-mongo")?.name = "infra-mongo"

include("infra:infra-rds")
findProject(":infra:infra-rds")?.name = "infra-rds"