package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.StreamDelete$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelApplicationStream6<T> implements Action1<String> {
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $reasonStr;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $unavailable;

    public ModelApplicationStream6(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$reasonStr = ref$ObjectRef2;
        this.$unavailable = ref$ObjectRef3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1194435296) {
                if (iHashCode != -934964668) {
                    if (iHashCode == -665462704 && str.equals("unavailable")) {
                        this.$unavailable.element = (T) this.$reader.nextBooleanOrNull();
                        return;
                    }
                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                    this.$reasonStr.element = (T) this.$reader.nextStringOrNull();
                    return;
                }
            } else if (str.equals("stream_key")) {
                Ref$ObjectRef ref$ObjectRef = this.$streamKey;
                T t = (T) this.$reader.nextStringOrNull();
                Intrinsics3.checkNotNull(t);
                ref$ObjectRef.element = t;
                return;
            }
        }
        this.$reader.skipValue();
    }
}
