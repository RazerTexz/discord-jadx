package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$1 implements Runnable {
    public final /* synthetic */ Ref$IntRef $bucketInt;
    public final /* synthetic */ Model.JsonReader $reader;

    public GuildExperimentBucketDto$Parser$parse$1(Ref$IntRef ref$IntRef, Model.JsonReader jsonReader) {
        this.$bucketInt = ref$IntRef;
        this.$reader = jsonReader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref$IntRef ref$IntRef = this.$bucketInt;
        ref$IntRef.element = this.$reader.nextInt(ref$IntRef.element);
    }
}
