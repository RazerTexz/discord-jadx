package kotlin.reflect;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.KAnnotatedElement;
import d0.e0.KParameter;
import d0.e0.KTypeParameter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: KCallable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\f8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0016\u001a\u00020\u00158&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u00020\u00158&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u00158&@'X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\u0017R\u001c\u0010!\u001a\u00020\u00158&@'X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b!\u0010\u0017R\u001e\u0010'\u001a\u0004\u0018\u00010#8&@'X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%R\u0016\u0010+\u001a\u00020(8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lkotlin/reflect/KCallable;", "R", "Ld0/e0/b;", "", "", "args", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Ld0/e0/f;", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "", "getParameters", "()Ljava/util/List;", "parameters", "Ld0/e0/h;", "getTypeParameters", "getTypeParameters$annotations", "()V", "typeParameters", "", "isSuspend", "()Z", "isSuspend$annotations", "isAbstract", "isAbstract$annotations", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "", "getName", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public interface KCallable<R> extends KAnnotatedElement {
    R call(Object... args);

    R callBy(Map<KParameter, ? extends Object> args);

    String getName();

    List<KParameter> getParameters();

    KType getReturnType();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
