DESCRIPTION = "cpptoml - A header-only library for parsing TOML configuration files. "
SECTION = "extended"
#DEPENDS = "ncurses acl"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=8739ce451f437fa9493b37a405fb16f1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "fededad7169e538ca47e11a9ee9251bc361a9a65"

SRC_URI = "git://github.com/skystrife/cpptoml.git;branch=master;protocol=https"
SRC_URI[sha256sum] = "f34a8caafe005c2aa873967b367b5fa1342cdaf2e234172d346a92994f776623"

S = "${WORKDIR}/git"

inherit cmake 
BBCLASSEXTEND = "native"

EXTRA_OECMAKE += "-DCPPTOML_BUILD_EXAMPLES=OFF"

FILES_${PN} += " \
        ${incdir}/cpptoml.h \
"

#SYSROOT_DIRS += "${bindir}"

# Get rid of default configuration
#do_install:append() {
#
#	rm -rf ${D}/usr/etc
#}
