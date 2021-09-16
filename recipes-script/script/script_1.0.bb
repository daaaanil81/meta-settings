#
# Yocto Project Development Manual.
#

DESCRIPTION = "Camera application for Yocto build."
SECTION = "script"

DEPENDS = "camera"

SRC_URI = "file://camera.service \
           file://LICENSE \
          "

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SYSTEMD_AUTO_ENABLE = "enable"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a0c0175b6c5777598862c6e1a02eb886"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = "camera.service"

FILES_${PN} += " ${systemd_unitdir}/system/camera.service \
"

do_install () {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0755 ${WORKDIR}/camera.service ${D}/${systemd_unitdir}/system
}

