/**
 *  eCommerce Application
 *
 *  Copyright (c) 2022 - 2024 Ionut Balosin
 *  Website: www.ionutbalosin.com
 *  X: @ionutbalosin | LinkedIn: ionutbalosin | Mastodon: ionutbalosin@mastodon.social
 *
 *
 *  MIT License
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 */
package ionutbalosin.training.ecommerce.shopping.cart.dto.mapper;

import static java.util.stream.Collectors.toList;

import ionutbalosin.training.ecommerce.shopping.cart.api.model.CartItemDto;
import ionutbalosin.training.ecommerce.shopping.cart.api.model.CartItemIdDto;
import ionutbalosin.training.ecommerce.shopping.cart.model.CartItem;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CartItemDtoMapper {

  public CartItemDto map(CartItem cartItem) {
    return new CartItemDto()
        .itemId(cartItem.getId())
        .productId(cartItem.getProductId())
        .quantity(cartItem.getQuantity())
        .discount(cartItem.getDiscount());
  }

  public List<CartItemIdDto> map(Set<UUID> uuids) {
    return uuids.stream().map(uuid -> new CartItemIdDto().itemId(uuid)).collect(toList());
  }
}
