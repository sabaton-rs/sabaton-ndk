DESCRIPTION = "Eclipse iceoryx™ - true zero-copy inter-process-communication "
SECTION = "connectivity"
DEPENDS = "ncurses acl cpptoml"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "f756b7c99ddf714d05929374492b34c5c69355bb"
SRC_URI = "git://github.com/eclipse-iceoryx/iceoryx.git;protocol=https;branch=release_2.0"

S = "${WORKDIR}/git/iceoryx_meta"

inherit cmake 
BBCLASSEXTEND = "native"

EXTRA_OECMAKE += "-DROUDI_ENVIRONMENT=ON -DDOWNLOAD_TOML_LIB=OFF"

FILES_${PN} += " \
        ${bindir}/iox-roudi \
"

SYSROOT_DIRS += "${bindir}"

# Get rid of default configuration
do_install:append() {

	rm -rf ${D}/usr/etc
}
