package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.api.application.Application;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelLibraryApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelLibraryApplication$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelLibraryApplication2<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $application;
    public final /* synthetic */ Ref$ObjectRef $branchId;
    public final /* synthetic */ Ref$ObjectRef $createdAt;
    public final /* synthetic */ Ref$ObjectRef $flags;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $skuId;

    public ModelLibraryApplication2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.$application = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$createdAt = ref$ObjectRef2;
        this.$skuId = ref$ObjectRef3;
        this.$flags = ref$ObjectRef4;
        this.$branchId = ref$ObjectRef5;
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
                case -900217987:
                    if (str.equals("sku_id")) {
                        this.$skuId.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
                case -787623720:
                    if (str.equals("branch_id")) {
                        this.$branchId.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
                case 97513095:
                    if (str.equals("flags")) {
                        this.$flags.element = (T) this.$reader.nextIntOrNull();
                        return;
                    }
                    break;
                case 1369680106:
                    if (str.equals("created_at")) {
                        this.$createdAt.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 1554253136:
                    if (str.equals("application")) {
                        this.$application.element = (T) ((Application) InboundGatewayGsonParser.fromJson(this.$reader, Application.class));
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
