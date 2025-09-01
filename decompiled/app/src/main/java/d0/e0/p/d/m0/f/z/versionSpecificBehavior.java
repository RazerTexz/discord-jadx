package d0.e0.p.d.m0.f.z;

import d0.z.d.Intrinsics3;

/* compiled from: versionSpecificBehavior.kt */
/* renamed from: d0.e0.p.d.m0.f.z.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class versionSpecificBehavior {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion binaryVersion) {
        Intrinsics3.checkNotNullParameter(binaryVersion, "version");
        return binaryVersion.getMajor() == 1 && binaryVersion.getMinor() >= 4;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion binaryVersion) {
        Intrinsics3.checkNotNullParameter(binaryVersion, "version");
        return isKotlin1Dot4OrLater(binaryVersion);
    }
}
