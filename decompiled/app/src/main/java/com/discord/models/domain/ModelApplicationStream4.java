package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelApplicationStream4<T> implements Action1<String> {
    public final /* synthetic */ Ref$BooleanRef $paused;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $rtcServerId;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $viewerIds;

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Long> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Long get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Long get() {
            return Long.valueOf(ModelApplicationStream4.this.$reader.nextLong(0L));
        }
    }

    public ModelApplicationStream4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$rtcServerId = ref$ObjectRef2;
        this.$paused = ref$BooleanRef;
        this.$viewerIds = ref$ObjectRef3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -1349214453:
                    if (str.equals("viewer_ids")) {
                        this.$viewerIds.element = (T) this.$reader.nextList(new AnonymousClass1());
                        return;
                    }
                    break;
                case -1194435296:
                    if (str.equals("stream_key")) {
                        Ref$ObjectRef ref$ObjectRef = this.$streamKey;
                        T t = (T) this.$reader.nextStringOrNull();
                        Intrinsics3.checkNotNull(t);
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        Ref$BooleanRef ref$BooleanRef = this.$paused;
                        Boolean boolNextBooleanOrNull = this.$reader.nextBooleanOrNull();
                        Intrinsics3.checkNotNullExpressionValue(boolNextBooleanOrNull, "reader.nextBooleanOrNull()");
                        ref$BooleanRef.element = boolNextBooleanOrNull.booleanValue();
                        return;
                    }
                    break;
                case -490387655:
                    if (str.equals("rtc_server_id")) {
                        this.$rtcServerId.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
