SUMMARY = "A header-only library for parsing TOML configuration files."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=8739ce451f437fa9493b37a405fb16f1"
BRANCH = "master"
SRC_URI = "git://github.com/skystrife/cpptoml.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "fededad7169e538ca47e11a9ee9251bc361a9a65"

SRC_URI_append = " file://0001_add_limits_h.patch"

DEPENDS = ""
RDEPENDS_${PN} = ""

inherit cmake

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \	
			-DCMAKE_PREFIX_PATH=${libdir} \
			-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
			"

# Install CMake modules in the location that BitBake looks.
do_install_append() {

	install -d ${D}${datadir}/cmake/Modules
	install -m 0444 ${WORKDIR}/git/cmake/cpptomlConfig.cmake.in ${D}${datadir}/cmake/Modules
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}-staticdev += "${includedir}/* ${libdir}/* ${datadir}/*"

