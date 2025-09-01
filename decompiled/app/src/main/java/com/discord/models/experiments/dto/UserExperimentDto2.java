package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: UserExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserExperimentDto2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $nameHash;
    public final /* synthetic */ Model.JsonReader $reader;

    public UserExperimentDto2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$nameHash = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$nameHash.element = this.$reader.nextLongOrNull();
    }
}
