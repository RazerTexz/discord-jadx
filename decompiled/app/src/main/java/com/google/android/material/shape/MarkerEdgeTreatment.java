package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        float fSqrt = (float) ((Math.sqrt(2.0d) * this.radius) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(fSqrt, 2.0d));
        shapePath.reset(f2 - fSqrt, ((float) (-((Math.sqrt(2.0d) * this.radius) - this.radius))) + fSqrt2);
        shapePath.lineTo(f2, (float) (-((Math.sqrt(2.0d) * this.radius) - this.radius)));
        shapePath.lineTo(f2 + fSqrt, ((float) (-((Math.sqrt(2.0d) * this.radius) - this.radius))) + fSqrt2);
    }
}
