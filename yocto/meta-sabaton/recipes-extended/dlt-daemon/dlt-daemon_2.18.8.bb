SUMMARY = "Diagnostic Log and Trace"
DESCRIPTION = "This component provides a standardised log and trace interface, \
based on the standardised protocol specified in the AUTOSAR standard 4.0 DLT. \
This component can be used by GENIVI components and other applications as \
logging facility providing: \
- the DLT shared library \
- the DLT daemon, including startup scripts \
- the DLT daemon adaptors- the DLT client console utilities \
- the DLT test applications"
HOMEPAGE = "https://www.genivi.org/"
SECTION = "console/utils"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8184208060df880fe3137b93eb88aeea"

DEPENDS = "zlib gzip-native pkgconfig-native"

SRC_URI = "git://github.com/COVESA/${BPN}.git;protocol=https \
"
SRCREV = "1438fcf8c88cd47b20b2984180a8457c3eb9193d"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES','systemd', d)}"
# General options
PACKAGECONFIG[dlt-examples] = "-DWITH_DLT_EXAMPLES=ON,-DWITH_DLT_EXAMPLES=OFF,,dlt-daemon-systemd"

# Linux options
PACKAGECONFIG[systemd] = "-DWITH_SYSTEMD=ON,-DWITH_SYSTEMD=OFF,systemd"
PACKAGECONFIG[systemd-watchdog] = "-DWITH_SYSTEMD_WATCHDOG=ON,-DWITH_SYSTEMD_WATCHDOG=OFF,systemd,libsystemd"
PACKAGECONFIG[systemd-journal] = "-DWITH_SYSTEMD_JOURNAL=ON,-DWITH_SYSTEMD_JOURNAL=OFF,systemd,libsystemd"
PACKAGECONFIG[dlt-dbus] = "-DWITH_DLT_DBUS=ON,-DWITH_DLT_DBUS=OFF,dbus,dbus-lib"
PACKAGECONFIG[udp-connection] = "-DWITH_UDP_CONNECTION=ON,-DWITH_UDP_CONNECTION=OFF"

# Command line options
#PACKAGECONFIG[dlt-system] = "-DWITH_DLT_SYSTEM=ON, -DWITH_DLT_SYSTEM=OFF"
PACKAGECONFIG[dlt-adaptor] = "-DWITH_DLT_ADAPTOR=ON,-DWITH_DLT_ADAPTOR=OFF,,dlt-daemon-systemd"
PACKAGECONFIG[dlt-console] = "-DWITH_DLT_CONSOLE=ON,-DWITH_DLT_CONSOLE=OFF,,dlt-daemon-systemd"

inherit autotools gettext cmake systemd

EXTRA_OECMAKE += "-DWITH_DLT_SYSTEM=ON "
FILES_${PN}-doc += "${datadir}/dlt-filetransfer"

do_install:append() {
    rm -f ${D}${bindir}/dlt-test-*
    rm -rf ${D}/usr/lib/systemd
    rm -rf ${D}/usr/share
} 
