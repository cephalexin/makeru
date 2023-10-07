plugins {
    id("makeru.base-conventions")
    alias(libs.plugins.lombok)
}

dependencies {
    api(project(":reactor"))
    api(libs.r2dbc.spi)
    implementation(libs.reactor.core)
    compileOnly(libs.jb.annotations)
}
