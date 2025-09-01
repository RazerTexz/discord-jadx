package b.i.a.c.d3;

import b.i.a.c.d3.SpannedToHtmlConverter;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Comparator {
    public static final /* synthetic */ f j = new f();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        SpannedToHtmlConverter.c cVar = (SpannedToHtmlConverter.c) obj;
        SpannedToHtmlConverter.c cVar2 = (SpannedToHtmlConverter.c) obj2;
        int iCompare = Integer.compare(cVar2.a, cVar.a);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = cVar2.c.compareTo(cVar.c);
        return iCompareTo != 0 ? iCompareTo : cVar2.d.compareTo(cVar.d);
    }
}
