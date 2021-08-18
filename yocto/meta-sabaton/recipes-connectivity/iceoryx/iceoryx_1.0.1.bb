DESCRIPTION = "Eclipse iceoryx™ - true zero-copy inter-process-communication "
SECTION = "connectivity"
DEPENDS = "ncurses acl"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "a07d83b7cfc5fc3f93d9bbd21b22830b65a0ba2e"
SRC_URI = "git://github.com/eclipse-iceoryx/iceoryx.git;protocol=https;branch=release_1.0"
#SRC_URI = "git://<host>/path/to/<repo>.git;protocol=<protocol>;user=<user>:<password>;branch=<branch>

S = "${WORKDIR}/git/iceoryx_meta"

inherit cmake 
BBCLASSEXTEND = "native"

EXTRA_OECMAKE += "-DROUDI_ENVIRONMENT=ON"

FILES_${PN} += " \
        ${bindir}/iox-roudi \
"

SYSROOT_DIRS += "${bindir}"

# Get rid of default configuration
do_install_append() {

	rm -rf ${D}/usr/etc
}
