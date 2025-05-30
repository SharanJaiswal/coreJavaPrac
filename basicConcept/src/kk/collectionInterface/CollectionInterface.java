package kk.collectionInterface;

import java.util.Collection;

public class CollectionInterface {
    /**
     * Collection is a part of java collection framework, an interface which exposes API to manage group of things by various collection classes.
     * Collection<E>. Parent|top-most interface. Super interface: Iterable<E>
     * It must support Lowest common methods that could be implemented by all the child collections implementing it. For example, add(ele), but not get(idx).
     * Map doesn't implement Collection interface.
     * This interface has some optional methods which child collection classes choose not to provide functionality to it during overriding, by throwing UnsupportedOperationException.
     * For example, immutability operations.
     *
     * add, addAll, clear, contains, remove, removeAll, retainAll, isEmpty, size, iterator, stream, toArray, etc.
     * No direct implementation in JDK.
     *
     */
}
