package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z2) {
        this.size = f;
        this.inside = z2;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f2 - (this.size * f3), 0.0f);
        shapePath.lineTo(f2, (this.inside ? this.size : -this.size) * f3);
        shapePath.lineTo((this.size * f3) + f2, 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
